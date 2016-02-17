//
//  JHDataFileWriter.m
//  Study2
//
//  Created by 박종훈 on 2016. 2. 3..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHDataFileWriter.h"

@interface JHDataFileWriter()
{
    
}

@property (nonatomic, retain)NSString* fileName;

@end

@implementation JHDataFileWriter


- (void)dealloc
{
    [super dealloc];
    [_fileName release];
}


- (instancetype) initWithFileName:(NSString*)fileName
{
    self = [super init];
    if(self)
    {
        _fileName = fileName;
    }
    
    return self;
}
#pragma mark - JHDataWriter
- (void)writeData:(NSArray*)dataArray
{
    if (dataArray == nil) {
        return;
    }
    
    NSData * data = [NSKeyedArchiver archivedDataWithRootObject:dataArray];
    
    NSString *filePath = [NSString stringWithFormat:@"%@/%@", NSHomeDirectory(), _fileName];
    BOOL success = [data writeToFile:filePath atomically:YES];
    
    if (success) {
    NSLog(@"write success");
    } else {
        NSLog(@"write fail");
    }
    
//    NSMutableString* text = [[NSMutableString alloc]init];
//    for (JHStudent *each in data) {
//        
//        NSData *data = [NSKeyedArchiver archivedDataWithRootObject:each];
//
//        [text appendFormat:@"%@ %zd\n",each.studentNo, [each studentJumsu]];
//        
//    }
//    NSLog(@"text : %@",text);
//    
//    NSArray* paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
//    
//    NSString* documentsDirectory = [paths objectAtIndex:0];
//
//    NSLog(@"path %@", documentsDirectory);
//    NSLog(@"_fileName : %@", _fileName);
//    
//    NSString* fullFileName = [NSString stringWithFormat:@"%@/%@", documentsDirectory, _fileName];
//    
//    NSLog(@"path %@", fullFileName);
//    
//    const char* szFilePath = [fullFileName UTF8String];
//    
//    FILE* fp = fopen(szFilePath, "w");
//    
//    if(fp == nil)
//    {
//        NSLog(@"파일이 없습니다");
//    }
//    else
//    {
//        const char* ctextData = [text UTF8String];
//        fputs(ctextData, fp);
//        NSLog(@"파일 쓰기 완료");
//    }
//    
//    
//    [documentsDirectory release];
//    [paths release];
//    [text release];
}

@end


//TEXT파일 생성 & 파일에 내용 저장
//NSArray* paths = NSSearchPathForDirectoriesInDomains( NSDocumentDirectory, NSUserDomainMask, YES );
//NSString* documentsDirectory = [paths objectAtIndex:0];
//
//NSString* fullFileName = [NSString stringWithFormat:@"%@/%@", documentsDirectory,@"log.txt"];
//
//const char* szFilePath = [fullFileName UTF8String];
//
//FILE* fp = fopen( szFilePath, "w" );
//if(fp == nil)     NSLog(@"do not exist log file");
//else
//{
//    NSString *tableAtt = @"haejinLee";
//    // NSString을 char로 바꾸는 작업,
//    // 굳이 NSString을 만들지 않아도 되는상황에선 char를 먼저 사용합니다.
//    const char* ctableAtt = [tableAtt UTF8String];
//    fputs(ctableAtt, fp);
//}
//아이폰으로 실행시켜 보면
//파일이 저장경로는 My Computer에서 Raw File System에서
//(저는 i-FunBox에서 확인하였습니다)
////var/mobile/Applications/어플번호/Documents에서 확인하실수 있습니다.
//어플번호를 몰라서 당황하시는 분들은
//당황하실 필요 없습니다..그냥 자신의 아이폰에 저장되어 있는 어플 (개발 목적으로 넣은어플)
//중에 하나..입니다.




//private String fileName = "";
//
//
//public String getFileName() {
//    return fileName;
//}
//
//public void setFileName(String fileName) {
//    this.fileName = fileName;
//}
//
//@Override
//public void writeData(List<Student> data) {
//    try
//    {
//        String text = "";
//        for(int i=0; i<data.size(); i++)
//        {
//            text += data.get(i).getStudentNo()+ " " + data.get(i).getStudentJumsu() + "\n";
//        }
//        
//        //txt파일 생성 및 작성 true로 주면 그뒤에 이어서 작성
//        FileWriter fileWriter = new FileWriter(fileName+".txt");
//        
//        fileWriter.write(text);
//        fileWriter.flush();
//        
//        fileWriter.close();
//    }
//    catch(Exception e)
//    {
//        e.printStackTrace();			
//    }
//    
//}
