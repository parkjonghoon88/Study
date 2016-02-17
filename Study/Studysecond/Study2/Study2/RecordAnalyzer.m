//
//  RecordAnalyzer.m
//  Study2
//
//  Created by 박종훈 on 2016. 2. 6..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "RecordAnalyzer.h"

@interface RecordAnalyzer()
{
    
}

@property (nonatomic,retain)NSString* fileName;
@property (nonatomic,retain)NSString* commandString;

@end

@implementation RecordAnalyzer


- (void)dealloc
{
    [super dealloc];
    [_fileName release];
    [_commandString release];
}

- (instancetype) initWithAnalyzer:(NSString*)commandString FileName:(NSString *)fileName
{
    self = [super init];
    if(self)
    {
        _fileName = fileName;
        _commandString = commandString;
    }
    
    return self;
    
}

- (void) run
{
    
    JHDataFileReader* dataFileReader = [[JHDataFileReader alloc] init];
    [dataFileReader initWithFileName:_fileName];
    
    _commandString = [_commandString capitalizedString];
    
    NSString *className = [NSString stringWithFormat:@"JH%@Command",_commandString];
    id<JHCommand> object = [[NSClassFromString(className) alloc] init];
    
    [self readAndAnalyzerData:object Reader:dataFileReader];

}

- (void) readAndAnalyzerData:(id<JHCommand>)command Reader:(JHDataFileReader*)reader
{
    [command execute:reader.students];
}

@end



//public class RecordAnalyzer {
//    
//    
//    public static void main(String[] args) {
//        
//        if (args.length < 2) {
//            System.err.println("옵션을 입력해주세요");
//            System.exit(1);
//        }
//        
//        String commandString = args[0];
//        String dataFile = args[1];
//        
//        DataFileReader dataFileReader = new DataFileReader();
//        dataFileReader.setFileName(dataFile);
//        
//        DataProvider provider = dataFileReader;
//        
//        Command command = getCommand(commandString);
//        if (command == null) {
//            System.err.println("옵션을 다시 확인해주세요.");
//            System.exit(1);
//        }
//        
//        readAndAnalyzerData(provider, command);
//    }
//    
//    private static Command getCommand(String commandString) {
//        commandString = commandString.toUpperCase().substring(0, 1) +
//        commandString.toLowerCase().substring(1);
//        
//        String commandClassName = Command.class.getPackage().getName() + "." + commandString + "Command";
//        
//        Command command = null;
//        try{
//            Class<?> cls = Class.forName(commandClassName);
//            Constructor<?> ct = cls.getConstructor();
//            command = (Command) ct.newInstance();
//            
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        
//        return command;
//    }
//    
//    public static void readAndAnalyzerData(DataProvider provider, Command command){
//        if (provider.getStudents().size() > 0) {
//            command.execuet(provider.getStudents());
//        } else {
//            System.err.println("데이터가 존재하지 않습니다.");
//            System.exit(1);
//        }
//    }
//    
//    
//}
