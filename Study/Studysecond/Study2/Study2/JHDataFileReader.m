//
//  JHDataFileReader.m
//  Study2
//
//  Created by 박종훈 on 2016. 2. 6..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "JHDataFileReader.h"

@interface JHDataFileReader(){
    
}
@property (nonatomic,retain) NSString* fileName;

@end

@implementation JHDataFileReader


- (void)dealloc
{
    [super dealloc];
    [_fileName release];
}

- (instancetype) initWithFileName:(NSString*) fileName
{
    self = [super init];
    if(self)
    {
        _fileName = fileName;
    }
    
    return self;
}

- (NSArray*) students
{
    NSString *filePath = [NSString stringWithFormat:@"%@/%@", NSHomeDirectory(), _fileName];
    NSData * data = [NSData dataWithContentsOfFile:filePath];
    
    NSArray *students = [NSKeyedUnarchiver unarchiveObjectWithData:data];
    return students;

}

@end


//public class DataFileReader implements DataProvider {
//    private String fileName = "";
//    
//    
//    public String getFileName() {
//        return fileName;
//    }
//    
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//    
//    @Override
//    public List<Student> getStudents() {
//        List<Student> list = new ArrayList<>();
//        try
//        {
//            
//            BufferedReader in = new BufferedReader(new FileReader(fileName + ".txt"));
//            String strData;
//            
//            while ((strData = in.readLine()) != null)
//            {
//                Student object = new Student();
//                object.setStudentNo(strData.substring(0, 7));
//                object.setStudentJumsu(Integer.parseInt(strData.substring(8)));
//                System.out.println(strData);
//                list.add(object);
//            }
//            
//            in.close();
//        } catch (IOException e) {
//            System.err.println(e);// 에러가 있다면 메시지 출력
//            System.exit(1);
//        }
//        return list;
//    }
//    
//}
